package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.teleop.actions.DebugAction;
import org.firstinspires.ftc.teamcode.teleop.actions.MoveRobotAction;

@TeleOp(name = "TeleOpDebug", group = "debug")


public class TeleOpDebug extends TeleOpBase {
    @Override
    public void entry() {
        new MoveRobotAction.MoveRobotMobilityDriver(this);
    }

    @Override
    public void runLoop() {

    }
}
