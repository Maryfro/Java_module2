package telran.data;

public class Phone {

    public static void main(String[] args) {
        System.out.println(validatePhoneNumber("007 8764560"));
        System.out.println(validatePhoneNumber("0078764560"));
    }

    public static boolean validatePhoneNumber(String number) {
        class PhoneNumber {
            private String phoneNumber;

            private PhoneNumber() {
                phoneNumber = number;
            }

            private boolean checkCode() {
                return phoneNumber.charAt(0) == '0' && phoneNumber.indexOf(' ') == 3
                        && phoneNumber.substring(1, 3).matches("[0-9]+");
            }

            private boolean checkNumber() {
                return phoneNumber.length() == 11 && phoneNumber.substring(4).matches("[0-9]+");
            }
        }
        PhoneNumber phoneNumber = new PhoneNumber();
        return phoneNumber.checkCode() && phoneNumber.checkNumber();
    }
}
