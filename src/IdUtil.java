public class IdUtil {

    public static String getTicketId(int i, int j) {
        return i + " " + j;
    }

    public static Slot getSlot(String ticket) {
        String[] s = ticket.split(" ");
        Slot slot = new Slot(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        System.out.println(slot);
        return slot;
    }
}
