package lan.training.jdk7features;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class TryWithResources {
    public static void main(String[] args) throws Exception {

        try ( OpenDoor door = new OpenDoor(true) ) {
            door.swing(); //this throws a SwingExecption
        }
        catch (SwingException | DoorException e) {
            System.out.println("Is there a draft? " + e.getClass());
            int suppressedCount = e.getSuppressed().length;
            System.out.println("Suppressed count: " + suppressedCount);
            for (int i=0; i<suppressedCount; i++){
                System.out.println("Suppressed: " + e.getSuppressed()[i]);
            }
        }
        finally {
            System.out.println("I'm putting a sweater on, regardless. ");
        }
    }
}

class DoorException extends Exception {}
class SwingException extends Exception {}
class CloseException extends Exception {}

class OpenDoor implements AutoCloseable {

    public OpenDoor(Boolean broken) throws Exception {
        System.out.println("The door is open.");
        if (broken) {
            throw new DoorException();
        }
    }
    public void swing() throws Exception {
        System.out.println("The door is becoming unhinged.");
        throw new SwingException();
    }

    public void close() throws Exception {
        System.out.println("The door is closed.");
        throw new CloseException(); // throwing CloseException
    }
}
