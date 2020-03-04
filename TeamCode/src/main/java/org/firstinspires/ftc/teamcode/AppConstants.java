package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;

@Config
public class AppConstants {

    @Config
    public static class robotMovement {
        public static double MOVEMENT_SPEED = 0.8;
        public static double MOVEMENT_SPEED_FAST = 1.0;
        public static double MOVEMENT_SPEED_SLOW = 0.7;
        public static double DECELERATION_POINT = 0.5;
    }

    @Config
    public static class odometry {
        public static int COUNTS_PER_CENTIMETER = 279;
        public static double ALLOWABLE_DISTANCE_ERROR_CENTIMETER = 2.0;
        public static double MIN_SPEED = 0.2;
    }


    @Config
    public static class intakeMotors {
        public static double INTAKE_SPEED = 1.0;
    }


    @Config
    public static class servoMotors {
        public static double STONE_HOOK_HOLD = 1.0;
        public static double STONE_HOOK_IDLE = 0.0;

        public static double PLACING_EXTENDED = 1.0;
        public static double PLACING_IDLE = 0.0;

        public static double FOUNDATION_HOOK_IDLE = 1.0;
        public static double FOUNDATION_HOOK_HOLD = 0.0;
    }

    @Config
    public static class ticks {
        public static double TICKS_PER_CENTIMETER = 21.5;
    }
}