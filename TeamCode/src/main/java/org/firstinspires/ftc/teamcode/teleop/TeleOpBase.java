package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.arm.ArmsController;
import org.firstinspires.ftc.teamcode.arm.IntakeController;
import org.firstinspires.ftc.teamcode.movement.MovementController;
import org.firstinspires.ftc.teamcode.vision.WebcamVision;

/**
 * Abstract class which is our base TeleOp mode.
 * Initialises all <i>controller</i> classes for controlling our robot
 */

public abstract class TeleOpBase extends LinearOpMode {

    public MovementController movementController;
    public ArmsController armsController;
    public IntakeController intakeController;
    public FtcDashboard dashboard;
//    public WebcamVision webcamVision;

    //ArmsController armsController;

    @Override
    public void runOpMode() {

        movementController = new MovementController(hardwareMap, telemetry,
                this);
        armsController = new ArmsController(hardwareMap, telemetry, this);
        intakeController = new IntakeController(hardwareMap, telemetry, this);
//        webcamVision = new WebcamVision(hardwareMap, telemetry);
        dashboard = FtcDashboard.getInstance();



        while (!isStarted() && !isStopRequested()) {
            telemetry.addData("status",
                    "waiting for start command");
            telemetry.update();
            sleep(200);
        }


        entry();

        while(opModeIsActive()) {
            runLoop();
        }

    }

    public abstract void entry();

    public abstract void runLoop();

}