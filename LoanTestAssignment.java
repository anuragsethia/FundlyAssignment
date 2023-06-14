class LoanServiceTests {
     private final LoanService loanService;

    public LoanStoreTests() {
        LoanRepository loanRepository = new LoanRepositoryMock();
        loanService = new LoanService(loanRepository);
    }

    private Loan loan;
    private String lenderId;
    private String customerId;

    @Before
    public void setup() {
        openMocks(this);

        loan = new Loan();// Dummy loan with some values
        lenderId = "LEN1";
        customerId = "C1";
    }

    @Test
    void addLoan_Success() {
        Loan addedLoan = loanService.addLoan(loan);
        Assertions.assertEquals(loan, addedLoan);
    }

    @Test
    void addLoan_PaymentDateGreaterThanDueDate_Failed() {
        loan.setPaymentDate(date); // date after due date
        Assertions.assertThrows(IllegalArgumentException.class, () -> loanService.addLoan(loan));
    }

    @Test
    void addLoan_PastDueDate_Log() {
        loan.setDueDate(date) // Some past due date
        
        Logger logger = Logger.getLogger(LoanService.class.getName());
        logger.addHandler(new StreamHandler(outputStream, new SimpleFormatter()));
        
        loanService.addLoan(loan);
        
        String logOutput = outputStream.toString();
        Assertions.assertTrue(logOutput.contains("Loan with ID " + loan.getLoanId() + " has crossed the due date."));
    }

    @Test
    void getRemainingAmountTotalByLender_Success() {
        
        double expectedTotal = 15000.0; 
        double actualTotal = loanService.getRemainingAmountTotalByLender(lenderId);
        Assertions.assertEquals(expectedTotal, actualTotal);
    }

    @Test
    void getInterestTotalByLender_Success() {
        double expectedTotal = 300.0; 
        double actualTotal = loanService.getInterestTotalByLender(lenderId);
        Assertions.assertEquals(expectedTotal, actualTotal);
    }

    @Test
    void getPenaltyTotalByLender_Success() {
        double expectedTotal = 50.0; 
        double actualTotal = loanService.getPenaltyTotalByLender(lenderId);
        Assertions.assertEquals(expectedTotal, actualTotal);
    }

    @Test
    void getRemainingAmountTotalByInterest_Success() {
        double interestPerDay = 2.0;
        double expectedTotal = 60000.0;
        double actualTotal = loanService.getRemainingAmountTotalByInterest(interestPerDay);
        Assertions.assertEquals(expectedTotal, actualTotal);
    }

    @Test
    void getRemainingAmountTotalByCustomerId_Success() {
        double expectedTotal = 15000.0; 
        double actualTotal = loanService.getRemainingAmountTotalByCustomerId(customerId);
        Assertions.assertEquals(expectedTotal, actualTotal);
    }
}