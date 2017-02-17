package team1065.robot.frc2017.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team1065.robot.frc2017.Robot;

/**
 *
 */
public class AutoFarSide extends CommandGroup {

    public AutoFarSide() {
    	int allianceMultiplier = Robot.oi.isRedAlliance()? 1:-1;
    	//go score peg
    	addSequential(new DriveToDistance(0.4, 88, 15.0));
    	addSequential(new DriveForTime(0,0,0.5));
    	addSequential(new RotateToAngle(.4, 60 * allianceMultiplier, 15.0));
    	addSequential(new DriveForTime(0,0,0.5));
    	addSequential(new DriveToDistance(0.4, 29, 15.0));
    	addSequential(new PushGearForTime(1.0));
    	//go hopper
    	addSequential(new DriveToDistance(-0.4, 30, 15.0));
    	addSequential(new DriveForTime(0,0,0.5));
    	addSequential(new RotateToAngle(.4, -60 * allianceMultiplier, 15.0));
    	addSequential(new DriveForTime(0,0,0.3));
    	addSequential(new DriveToDistance(0.4, 160, 15.0));
    }
}
