package team1065.robot.frc2017.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team1065.robot.frc2017.Robot;

/**
 *
 */
public class AutoCenterRun extends CommandGroup {

    public AutoCenterRun() {
    	int allianceMultiplier = Robot.oi.isRedAlliance()? 1:-1;
    	
    	addSequential(new DriveToDistance(0.4, 75, 15.0));
    	addParallel(new PushGearForTime(1.0));
    	addSequential(new DriveForTime(0,0,0.2));
    	addSequential(new DriveToDistance(-0.46, 35, 15.0));
    	
    	addSequential(new RotateToAngle(.5, -90 * allianceMultiplier, 15.0));
    	addSequential(new DriveToDistance(0.5, 100, 15.0));
    	addSequential(new RotateToAngle(.5, 0 * allianceMultiplier, 15.0));
    	addSequential(new DriveToDistance(0.8, 220, 15.0));
    }
}
