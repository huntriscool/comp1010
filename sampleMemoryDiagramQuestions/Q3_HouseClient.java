class Room {
    public int length, width, height;

    public Room(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
}

class House {
    public Room room1, room2;

    public House(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }
}

public class Q3_HouseClient {
    public static void main(String[] args) {
        Room r1 = new Room(10, 15, 8);
        Room r2 = new Room(12, 18, 9);
        House h = new House(r1, r2);
    }
}
