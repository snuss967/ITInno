package com.gallup.gethip.model;

public class PasswordHolder {
	private String currentPassword;
	private String newPassword;
	public String getNewPassword()
	{
		return newPassword;
	}
	public String getCurrentPassword()
	{
		return currentPassword;
	}
	public void setNewPassword(String newPassword)
	{
		this.newPassword = newPassword;
	}
	public void setCurrentPassword(String currentPassword)
	{
		this.currentPassword = currentPassword;
	}
}
