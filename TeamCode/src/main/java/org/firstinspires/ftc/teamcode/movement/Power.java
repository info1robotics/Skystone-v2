package org.firstinspires.ftc.teamcode.movement;

public class Power {

    public double fl, fr, bl, br;


    public Power() {

    }

    public Power(double initialPower) {
        fl = fr = bl = br = initialPower;
    }

    public Power(double fl, double fr, double bl, double br) {
        this.fl = fl;
        this.fr = fr;
        this.bl = bl;
        this.br = br;
    }

    public Power(Power otherPower) {
        this.fl = otherPower.fl;
        this.fr = otherPower.fr;
        this.bl = otherPower.bl;
        this.br = otherPower.br;
    }



    public void setPower(Power power) {
        fl = power.fl;
        fr = power.fr;
        bl = power.br;
        br = power.br;
    }

    public void setPower(double speed) {
        fl = fr = bl = br = speed;
    }

    public Power multiply(Power otherPower) {
        return new Power(fl * otherPower.fl, fr * otherPower.fr,
                bl * otherPower.bl, br * otherPower.br);

    }

    public Power multiply(double coefficient) {
        return new Power(fl * coefficient, fr * coefficient,
                bl * coefficient, br * coefficient);

    }

    public Power subtract(Power otherPower) {
        return new Power(fl - otherPower.fl, fr - otherPower.fr,
                bl - otherPower.bl, br - otherPower.br);
    }

    public Power add(Power otherPower) {
        return new Power(fl + otherPower.fl, fr + otherPower.fr,
                bl + otherPower.bl, br + otherPower.br);
    }

    public String toString() {
        String res = "";
        res += ", fl ";
        res += Double.toString(fl);
        res += ", fr ";
        res += Double.toString(fr);
        res += ", bl ";
        res += Double.toString(bl);
        res += ", br ";
        res += Double.toString(br);
        return res;
    }


}
