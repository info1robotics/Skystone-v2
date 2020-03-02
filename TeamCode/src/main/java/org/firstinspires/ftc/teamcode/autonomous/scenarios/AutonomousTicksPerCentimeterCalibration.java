package org.firstinspires.ftc.teamcode.autonomous.scenarios;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autonomous.AutonomousBase;

@Autonomous(name = "1000 TICKS", group = "DEBUG")
public class AutonomousTicksPerCentimeterCalibration extends AutonomousBase {
    @Override
    public void runCommands() throws InterruptedException {
        movementController.move100Ticks();
    }
}
