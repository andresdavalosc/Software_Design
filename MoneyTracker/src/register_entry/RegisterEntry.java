package register_entry;

public class RegisterEntry {
    protected boolean checkedIn;

    public RegisterEntry(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public String toString() {
        String status;

        if (this.checkedIn) {
            status = "in_user";
        } else {
            status = "out_user";
        }

        return String.format("checked %s ", status);
    }
}
