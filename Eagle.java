public class Eagle extends Bird implements Fly{

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    @Override
    public String sing() {
        return "Screech!";
    }
    public int getAltitude() {
        return altitude;
    }
    public boolean isFlying() {
        return flying;
    }

    @Override
    public void takeOff() {
        if (!this.flying) {
            this.flying = true;
            System.out.printf("%s takes off in the sky.%n", this.getName());
        }
    }

    @Override
    public int ascend(int altitude) {
        if (this.flying) {
            this.altitude = Math.min(this.altitude + altitude, 1000);
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public void glide() {
        if (this.flying) {
            System.out.printf("%s glides into the air.%n", this.getName());
        }
    }

    @Override
    public int descend(int altitude) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - altitude, 0);
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public void land() {
        if (this.flying && this.altitude <= 1) {
            this.flying = false;
            System.out.printf("%s lands on the ground.%n", this.getName());
        } else {
            System.out.printf("%s is too high, it can't land.%n", this.getName());
        }
    }
}
