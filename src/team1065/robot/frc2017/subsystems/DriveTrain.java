package team1065.robot.frc2017.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team1065.robot.frc2017.RobotMap;
import team1065.robot.frc2017.commands.DriveWithJoysticks;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public enum State{TANK_DRIVE, STRAIGHT_DRIVE, MECANUM_DRIVE, STRAIGHT_MECANUM};
	
	private VictorSP leftFrontVictor, leftBackVictor, rightFrontVictor, rightBackVictor;
	private AHRS navX;
	private RobotDrive robotDrive;
	private State state;
	
	public DriveTrain(){
		leftFrontVictor = new VictorSP(RobotMap.LEFT_FRONT_DRIVE_MOTOR_PORT);
		leftBackVictor = new VictorSP(RobotMap.LEFT_BACK_DRIVE_MOTOR_PORT);
		rightFrontVictor = new VictorSP(RobotMap.RIGHT_FRONT_DRIVE_MOTOR_PORT);
		rightBackVictor = new VictorSP(RobotMap.RIGHT_BACK_DRIVE_MOTOR_PORT);
		rightFrontVictor.setInverted(true);
		rightBackVictor.setInverted(true);
    	
    	robotDrive = new RobotDrive(leftFrontVictor, leftBackVictor, rightFrontVictor, rightBackVictor);
    	robotDrive.setSafetyEnabled(false);
    	state = State.TANK_DRIVE;
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
    	robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
    	
    	try {
            navX = new AHRS(SPI.Port.kMXP); 
            navX.reset();
            navX.zeroYaw();
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void tankDrive(double leftValue, double rightValue){
    	if(state != State.TANK_DRIVE){
    		state = State.TANK_DRIVE;
    		resetAngle();
    		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        	robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
    	}
    	robotDrive.tankDrive(leftValue, rightValue, false);
    }
    
    public void straightDrive(double velocity){
    	if(state != State.STRAIGHT_DRIVE){
    		state = State.STRAIGHT_DRIVE;
    		resetAngle();
    		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        	robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
    	}
    	robotDrive.drive(velocity, -(getAngle() * RobotMap.STRAIGHT_DRIVE_P));
    }
    
    public void mecanumDrive(double x, double y, double rotation){
    	if(state != State.MECANUM_DRIVE){
    		state = State.MECANUM_DRIVE;
    		resetAngle();
    		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        	robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    	}
    	robotDrive.mecanumDrive_Cartesian(x, -y, rotation, 0);
    }
    
    public void mecanumStraightDrive(double x, double y){
    	if(state != State.STRAIGHT_MECANUM){
    		state = State.STRAIGHT_MECANUM;
    		resetAngle();
    		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        	robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    	}
    	robotDrive.mecanumDrive_Cartesian(x, -y, -(getAngle() * RobotMap.MECANUM_STRAIGHT_DRIVE_P), 0);
    }
    
    public double getAngle(){
    	try{
    		return navX.getAngle();
    	} catch (RuntimeException ex ) {
            return 0;
        }
    }
    
    public void resetAngle(){
    	try{
    		navX.reset();
    		navX.zeroYaw();
    	} catch (RuntimeException ex ) {
        }
    }
    
    public void updateStatus(){
    	SmartDashboard.putNumber("[DT] Angle", getAngle());
    }
    
}

