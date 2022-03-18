package by.bank.solution.command;

public class CommandData {
    private final String page;
    private final boolean isRedirect;

    public CommandData(String page, boolean isRedirect) {
        this.page = page;
        this.isRedirect = isRedirect;
    }

    public static CommandData forward(String page) {
        return new CommandData(page, false);
    }

    public static CommandData redirect(String page) {
        return new CommandData(page, true);
    }

    public String getPage() {
        return page;
    }

    public boolean isRedirect() {
        return isRedirect;
    }
}
