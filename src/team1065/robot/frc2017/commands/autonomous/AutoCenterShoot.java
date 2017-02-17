package team1065.robot.frc2017.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team1065.robot.frc2017.Robot;

/**
 *
 */
public class AutoCenterShoot extends CommandGroup {

    public AutoCenterShoot() {
    	int allianceMultiplier = Robot.oi.isRedAlliance()? 1:-1;
    	
    	addSequential(new DriveToDistance(0.4, 68, 15.0));
    	addSequential(new PushGearForTime(1.0));
    	
    	addSequential(new DriveToDistance(-0.4, 50, 15.0));
    	addSequential(new DriveForTime(0,0,0.5));
    	addSequential(new RotateToAngle(.4, 90 * allianceMultiplier, 15.0));
    	addSequential(new DriveForTime(0,0,0.5));
    	addSequential(new DriveToDistance(0.4, 68, 15.0));
    	addSequential(new DriveForTime(0,0,0.5));
    	addSequential(new RotateToAngle(.4, 135 * allianceMultiplier, 15.0));
    	addSequential(new DriveForTime(0,0,0.3));
    	addSequential(new SetShooterSpeed(1800));
    	addSequential(new DriveToDistance(0.4, 20, 15.0));
    	addSequential(new DriveForTime(0.3,0.3,1.0));
    	addSequential(new ShootForTime(5.0));
    }
}
