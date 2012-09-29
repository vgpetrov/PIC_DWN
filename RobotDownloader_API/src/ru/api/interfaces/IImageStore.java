/**
 * 
 */
package ru.api.interfaces;

import java.util.Date;

/**
 * @author VP
 *
 */
public interface IImageStore {
	/**
	 * Store image
	 * 
	 * @param dir
	 * @param fileName
	 * @param date
	 */
	public void putImageFile(String dir, String fileName, Date date);
}
