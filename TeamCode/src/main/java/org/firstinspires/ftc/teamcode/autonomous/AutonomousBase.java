package org.firstinspires.ftc.teamcode.autonomous;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.arm.ArmsController;
import org.firstinspires.ftc.teamcode.arm.IntakeController;
import org.firstinspires.ftc.teamcode.movement.MovementController;

import roadrunner.drive.mecanum.SampleMecanumDriveBase;
import roadrunner.drive.mecanum.SampleMecanumDriveREV;

public abstract class AutonomousBase extends LinearOpMode {
    public MovementController movementController;
    public ArmsController armController;
    public IntakeController intakeController;
    public SampleMecanumDriveBase roadController;

    private FtcDashboard dashboard;
    protected Telemetry dashboardTelemetry;

    public void runOpMode() {

        msStuckDetectStop = 2500;

        dashboard = FtcDashboard.getInstance();
        dashboardTelemetry = dashboard.getTelemetry();

        movementController = new MovementController(hardwareMap, telemetry,
                this);
        armController = new ArmsController(hardwareMap, telemetry, this);
        intakeController = new IntakeController(hardwareMap, telemetry, this);
        roadController = new SampleMecanumDriveREV(hardwareMap);



        while (!isStarted() && !isStopRequested()) {
            telemetry.addData("status",
                    "waiting for start command");
            telemetry.update();
            sleep(200);
        }

        try {
            runCommands();
        } catch(InterruptedException e) { }

    }

    public abstract void runCommands() throws InterruptedException;
}
