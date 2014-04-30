package org.jnect.tutorial.righthandtracker;

import java.io.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.jnect.bodymodel.*;
import org.jnect.core.KinectManager;

public class BodyTracker {
	
	static long f = 0;
	static boolean b = true;
	public static BodyTracker INSTANCE = new BodyTracker();
	
	BodyTracker(){
	};
	
	public void printBodyPosition(){
		KinectManager.INSTANCE.startKinect();
		KinectManager.INSTANCE.startSkeletonTracking();
		final long startTime = System.nanoTime();
		//final Body body = KinectManager.INSTANCE.getSkeletonModel();
		final RightHand righthand = KinectManager.INSTANCE.getSkeletonModel().getRightHand();
		final LeftHand lefthand = KinectManager.INSTANCE.getSkeletonModel().getLeftHand();
		final Head head = KinectManager.INSTANCE.getSkeletonModel().getHead();
		final CenterHip centerhip = KinectManager.INSTANCE.getSkeletonModel().getCenterHip();
		final CenterShoulder centershoulder = KinectManager.INSTANCE.getSkeletonModel().getCenterShoulder();
		final LeftAnkle leftankle = KinectManager.INSTANCE.getSkeletonModel().getLeftAnkle();
		final LeftElbow leftelbow = KinectManager.INSTANCE.getSkeletonModel().getLeftElbow();
		final LeftFoot leftfoot = KinectManager.INSTANCE.getSkeletonModel().getLeftFoot();
		final LeftHip lefthip = KinectManager.INSTANCE.getSkeletonModel().getLeftHip();
		final LeftKnee leftknee = KinectManager.INSTANCE.getSkeletonModel().getLeftKnee();
		final LeftShoulder leftshoulder = KinectManager.INSTANCE.getSkeletonModel().getLeftShoulder();
		final LeftWrist leftwrist = KinectManager.INSTANCE.getSkeletonModel().getLeftWrist();
		final RightAnkle rightankle = KinectManager.INSTANCE.getSkeletonModel().getRightAnkle();
		final RightElbow rightelbow = KinectManager.INSTANCE.getSkeletonModel().getRightElbow();
		final RightFoot rightfoot = KinectManager.INSTANCE.getSkeletonModel().getRightFoot();
		final RightHip righthip = KinectManager.INSTANCE.getSkeletonModel().getRightHip();
		final RightKnee rightknee = KinectManager.INSTANCE.getSkeletonModel().getRightKnee();
		final RightShoulder rightshoulder = KinectManager.INSTANCE.getSkeletonModel().getRightShoulder();
		final RightWrist rightwrist = KinectManager.INSTANCE.getSkeletonModel().getRightWrist();
		final Spine spine = KinectManager.INSTANCE.getSkeletonModel().getSpine();
		righthand.eAdapters().add(new Adapter() {
			@Override
			public void notifyChanged(Notification notification){
				
				if (System.nanoTime()-startTime-f>1000000000){
					try {
						b = verifierAcquisition(System.getProperty("user.dir")+ File.separator +  "boo" + ".txt");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						f = System.nanoTime()-startTime;
					}
				}
				if (b){
					long estimatedTime = System.nanoTime() - startTime;
					System.out.println("xcenterhip: " + centerhip.getX() + "| ycenterhip:" + centerhip.getY() + "| zcenterhip: " + centerhip.getZ() + "|t: " + estimatedTime );
					System.out.println("xcentershoulder: " + centershoulder.getX() + "| ycentershoulder:" + centershoulder.getY() + "| zcentershoulder: " + centershoulder.getZ() + "|t: " + estimatedTime );
					System.out.println("xhead: " + head.getX() + "| yhead:" + head.getY() + "| zhead: " + head.getZ() + "|t: " + estimatedTime );
					System.out.println("xleftankle: " + leftankle.getX() + "| yleftankle:" + leftankle.getY() + "| zleftankle: " + leftankle.getZ() + "|t: " + estimatedTime );
					System.out.println("xleftelbow: " + leftelbow.getX() + "| yleftelbow:" + leftelbow.getY() + "| zleftelbow: " + leftelbow.getZ() + "|t: " + estimatedTime );
					System.out.println("xleftfoot: " + leftfoot.getX() + "| yleftfoot:" + leftfoot.getY() + "| zleftfoot: " + leftfoot.getZ() + "|t: " + estimatedTime );
					System.out.println("xlefthand: " + lefthand.getX() + "| ylefthand:" + lefthand.getY() + "| zlefthand: " + lefthand.getZ() + "|t: " + estimatedTime );
					System.out.println("xlefthip: " + lefthip.getX() + "| ylefthip:" + lefthip.getY() + "| zlefthip: " + lefthip.getZ() + "|t: " + estimatedTime );
					System.out.println("xleftknee: " + leftknee.getX() + "| yleftknee:" + leftknee.getY() + "| zleftknee: " + leftknee.getZ() + "|t: " + estimatedTime );
					System.out.println("xleftshoulder: " + leftshoulder.getX() + "| yleftshoulder:" + leftshoulder.getY() + "| zleftshoulder: " + leftshoulder.getZ() + "|t: " + estimatedTime );
					System.out.println("xleftwrist: " + leftwrist.getX() + "| yleftwrist:" + leftwrist.getY() + "| zleftwrist: " + leftwrist.getZ() + "|t: " + estimatedTime );
					System.out.println("xrightankle: " + rightankle.getX() + "| yrightankle:" + rightankle.getY() + "| zrightankle: " + rightankle.getZ() + "|t: " + estimatedTime );
					System.out.println("xrightelbow: " + rightelbow.getX() + "| yrightelbow:" + rightelbow.getY() + "| zrightelbow: " + rightelbow.getZ() + "|t: " + estimatedTime );
					System.out.println("xrightfoot: " + rightfoot.getX() + "| yrightfoot:" + rightfoot.getY() + "| zrightfoot: " + rightfoot.getZ() + "|t: " + estimatedTime );
					System.out.println("xrighthand: " + righthand.getX() + "| yrighthand:" + righthand.getY() + "| zrighthand: " + righthand.getZ() + "|t: " + estimatedTime );
					System.out.println("xrighthip: " + righthip.getX() + "| yrighthip:" + righthip.getY() + "| zrighthip: " + righthip.getZ() + "|t: " + estimatedTime );
					System.out.println("xrightknee: " + rightknee.getX() + "| yrightknee:" + rightknee.getY() + "| zrightknee: " + rightknee.getZ() + "|t: " + estimatedTime );
					System.out.println("xrightshoulder: " + rightshoulder.getX() + "| yrightshoulder:" + rightshoulder.getY() + "| zrightshoulder: " + rightshoulder.getZ() + "|t: " + estimatedTime );
					System.out.println("xrightwrist: " + rightwrist.getX() + "| yrightwrist:" + rightwrist.getY() + "| zrightwrist: " + rightwrist.getZ() + "|t: " + estimatedTime );
					System.out.println("xspine: " + spine.getX() + "| yspine:" + spine.getY() + "| zspine: " + spine.getZ() + "|t: " + estimatedTime );
					System.out.println("");
				
				
					PrintWriter pw = null;
					try {
						String path = System.getProperty("user.dir") ;
						File file = new File(path + File.separator + "randomtest" + ".txt") ;
						System.out.println(file);
						pw = new PrintWriter (new FileOutputStream(file,true));
						
						pw.append("xcenterhip: " + centerhip.getX() + "| ycenterhip:" + centerhip.getY() + "| zcenterhip: " + centerhip.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xcentershoulder: " + centershoulder.getX() + "| ycentershoulder:" + centershoulder.getY() + "| zcentershoulder: " + centershoulder.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xhead: " + head.getX() + "| yhead:" + head.getY() + "| zhead: " + head.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xleftankle: " + leftankle.getX() + "| yleftankle:" + leftankle.getY() + "| zleftankle: " + leftankle.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xleftelbow: " + leftelbow.getX() + "| yleftelbow:" + leftelbow.getY() + "| zleftelbow: " + leftelbow.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xleftfoot: " + leftfoot.getX() + "| yleftfoot:" + leftfoot.getY() + "| zleftfoot: " + leftfoot.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xlefthand: " + lefthand.getX() + "| ylefthand:" + lefthand.getY() + "| zlefthand: " + lefthand.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xlefthip: " + lefthip.getX() + "| ylefthip:" + lefthip.getY() + "| zlefthip: " + lefthip.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xleftknee: " + leftknee.getX() + "| yleftknee:" + leftknee.getY() + "| zleftknee: " + leftknee.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xleftshoulder: " + leftshoulder.getX() + "| yleftshoulder:" + leftshoulder.getY() + "| zleftshoulder: " + leftshoulder.getZ() + "|t: " + estimatedTime+ '\n' );
						pw.append("xleftwrist: " + leftwrist.getX() + "| yleftwrist:" + leftwrist.getY() + "| zleftwrist: " + leftwrist.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xrightankle: " + rightankle.getX() + "| yrightankle:" + rightankle.getY() + "| zrightankle: " + rightankle.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xrightelbow: " + rightelbow.getX() + "| yrightelbow:" + rightelbow.getY() + "| zrightelbow: " + rightelbow.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xrightfoot: " + rightfoot.getX() + "| yrightfoot:" + rightfoot.getY() + "| zrightfoot: " + rightfoot.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xrighthand: " + righthand.getX() + "| yrighthand:" + righthand.getY() + "| zrighthand: " + righthand.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xrighthip: " + righthip.getX() + "| yrighthip:" + righthip.getY() + "| zrighthip: " + righthip.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xrightknee: " + rightknee.getX() + "| yrightknee:" + rightknee.getY() + "| zrightknee: " + rightknee.getZ() + "|t: " + estimatedTime + '\n' );
						pw.append("xrightshoulder: " + rightshoulder.getX() + "| yrightshoulder:" + rightshoulder.getY() + "| zrightshoulder: " + rightshoulder.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xrightwrist: " + rightwrist.getX() + "| yrightwrist:" + rightwrist.getY() + "| zrightwrist: " + rightwrist.getZ() + "|t: " + estimatedTime + '\n');
						pw.append("xspine: " + spine.getX() + "| yspine:" + spine.getY() + "| zspine: " + spine.getZ() + "|t: " + estimatedTime + '\n');
						pw.append('\n');
					} catch (Exception e) {
						e.printStackTrace();
					} finally { if (pw!=null)
						try {
							pw.close();
						} catch (Exception e) {}
					}
				}
			}
			
			@Override
			public Notifier getTarget(){
				return righthand;
			}
			
			@Override
			public void setTarget(Notifier newTarget){
				// TODO Auto-generated method stub
			}
			
			@Override
			public boolean isAdapterForType(Object type){
				//TODO Auto-generated method stub
				return false;
			}
		});
	}
	
	public void stop(){
		KinectManager.INSTANCE.stopKinect();
	}
	
	public boolean verifierAcquisition(String fileName) throws IOException{
		
		boolean b = false;
		int i = 0;
		BufferedReader bf = null;
		try {
			FileReader fr = new FileReader (fileName);
			bf = new BufferedReader(fr);
			String temp = bf.readLine();
			i = Integer.parseInt(temp);
			if (i==1) b = true;
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			bf.close();
		}
		return b;
	}


}