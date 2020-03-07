package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//import org.firstinspires.ftc.teamcode.teleop.actions.ArmsAction;
import org.firstinspires.ftc.teamcode.teleop.actions.ArmsAction;
import org.firstinspires.ftc.teamcode.teleop.actions.IntakeAction;
import org.firstinspires.ftc.teamcode.teleop.actions.MoveRobotAction;

@TeleOp(name = "TeleOp Default", group = "Default")
public class TeleOpDefault extends TeleOpBase {

    @Override
    public void entry() {
        new MoveRobotAction.MoveRobotMobilityDriver(this);
        new IntakeAction(this);
        new ArmsAction.ArmsElevation(this);
        new ArmsAction.ArmsPlacingAndPickup(this);
        new ArmsAction.ArmsFoundationHooks(this);

    }

    @Override
    public void runLoop() {
    }
}
