package payroll.claim;

class ClaimNotFoundException extends RuntimeException {

  ClaimNotFoundException(String msg) {
    super(msg);
  }
}