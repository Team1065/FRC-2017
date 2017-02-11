package team1065.robot.frc2017.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
    	addSequential(new DriveToDistance(0.4, 88, 15.0));
    	addSequential(new RotateToAngle(.45, 60, 15.0));
    	addSequential(new DriveToDistance(0.4, 30, 15.0));
    }
}
