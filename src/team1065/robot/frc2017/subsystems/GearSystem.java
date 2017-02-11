package team1065.robot.frc2017.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team1065.robot.frc2017.RobotMap;
import team1065.robot.frc2017.commands.ManualGearControl;

/**
 *
 */
public class GearSystem extends Subsystem {

    Solenoid intake, pusher;
    
    public GearSystem(){
    	intake = new Solenoid(RobotMap.GEAR_INTAKE_SOLENOID_PORT);
    	pusher = new Solenoid(RobotMap.GEAR_PUSHER_SOLENOID_PORT);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ManualGearControl());
    }
    
    public void openGearIntake(){
    	intake.set(true);
    }
    
    public void closeGearIntake(){
    	intake.set(false);
    }
    
    public void extendGearPusher(){
    	pusher.set(true);
    }
    
    public void retractGearPusher(){
    	pusher.set(false);
    }
}

