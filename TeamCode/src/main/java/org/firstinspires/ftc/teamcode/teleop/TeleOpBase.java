package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.arm.ArmsController;
import org.firstinspires.ftc.teamcode.arm.IntakeController;
import org.firstinspires.ftc.teamcode.movement.MovementController;
import org.firstinspires.ftc.teamcode.vision.WebcamVision;

import roadrunner.drive.mecanum.SampleMecanumDriveBase;
import roadrunner.drive.mecanum.SampleMecanumDriveREV;

/**
 * Abstract class which is our base TeleOp mode.
 * Initialises all <i>controller</i> classes for controlling our robot
 */

public abstract class TeleOpBase extends LinearOpMode {



    @Override
    public void runOpMode() {



        while (!isStarted() && !isStopRequested()) {
            telemetry.addData("status",
                    "waiting for start command");
            telemetry.update();
            sleep(200);
        }


        entry();


        while(opModeIsActive()) {
            runLoop();
            idle();
        }
    }

    public abstract void entry();

    public abstract void runLoop();

}