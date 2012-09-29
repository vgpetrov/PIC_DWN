/**
 * 
 */
package ru.api.interfaces;

import java.util.List;

/**
 * @author VP
 *
 */
public interface IImageDownload {
	/**
	 * Returns byteArray of image 
	 * 
	 * @param url
	 * @return
	 */
	public byte[] getImageFromSite(String url);

    /**
     * Returns all images from site
     *
     * @param url
     * @return
     */
    public List<String> getImagesList(String url);
}
