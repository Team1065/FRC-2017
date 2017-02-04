package team1065.robot.frc2017;

public class RobotMap {
	
	//PID Constants
    public static final double STRAIGHT_DRIVE_P = 0.052,
    		                   MECANUM_STRAIGHT_DRIVE_P = 0.052,
    		                   SHOOTER_F = 2.1,
	                		   SHOOTER_P = 0,
            				   SHOOTER_I = 0,
    						   SHOOTER_D = 0;
    
    //Shooter RPM values
    public static final double SHOOTER_RPM_0 = 0.0,
    						   SHOOTER_RPM_1 = 5600.0,
    						   SHOOTER_RPM_2 = 5700.0,
    						   SHOOTER_RPM_3 = 5800.0,
    						   SHOOTER_RPM_4 = 5850.0,
    						   SHOOTER_RPM_5 = 5900.0;
    
    //Shooter Voltage values
    public static final double SHOOTER_VOLT_0 = 0.0,
    						   SHOOTER_VOLT_1 = 0.45,
    						   SHOOTER_VOLT_2 = 0.50,
    						   SHOOTER_VOLT_3 = 0.55,
    						   SHOOTER_VOLT_4 = 0.6,
    						   SHOOTER_VOLT_5 = 1.0;
    
    //Double Constants
    public static final double JOYSTICK_DEADBAND = 0.05,
			                   DRIVE_STRAIGHT_BAND_PERCENTAGE = 0.2,
			                   INTAKE_IN_SPEED = 0.9,
			    			   INTAKE_OUT_SPEED = 1.0;
	
	//PWM Ports
    public static final int LEFT_FRONT_DRIVE_MOTOR_PORT = 0,
    				  	    RIGHT_FRONT_DRIVE_MOTOR_PORT = 1,
		  	    			LEFT_BACK_DRIVE_MOTOR_PORT = 2,
    				  	    RIGHT_BACK_DRIVE_MOTOR_PORT = 3,
    				  	    INTAKE_MOTOR_PORT = 4;
    
    //CANTalon Ports
    public static final int MASTER_TALON_PORT = 1,
    						SLAVE_TALON_PORT = 2;
    
    //OI
    //TODO: change names to match this year's usage
    public static final int LEFT_JOYSTICK_PORT = 0,
					  		RIGHT_JOYSTICK_PORT = 1,
					  		ENHANCED_DS_PORT = 2,
					  		COMPRESSOR_CONTROL_OVERRIDE = 2,//Digital
						    INTAKE_IN_PORT = 4,//Digital
						    INTAKE_OUT_PORT = 5,//Digital
						    SHOOTER_CONTROLLER_OVERRIDE = 9,//Digital
						    OBSTACLE_MANIPULATOR_SWITCH_PORT = 1,//digital
						    SHOOTER_LONG_DISTANCE_SWITCH_PORT = 12,//digital
				    		SHOOTER_KNOB_PORT = 0,//Analog
				    		AUTO_KNOB_PORT = 1;//Analog
    
    public static final double SHOOTER_KNOB_POS_0 = 0.000,
			   SHOOTER_KNOB_POS_1 = 0.024,
			   SHOOTER_KNOB_POS_2 = 0.047,
			   SHOOTER_KNOB_POS_3 = 0.071,
			   SHOOTER_KNOB_POS_4 = 0.094,
			   SHOOTER_KNOB_POS_5 = 0.118,
			   AUTO_KNOB_POS_0 = 0.000,
			   AUTO_KNOB_POS_1 = 0.024,
			   AUTO_KNOB_POS_2 = 0.055,
			   AUTO_KNOB_POS_3 = 0.087;
}
