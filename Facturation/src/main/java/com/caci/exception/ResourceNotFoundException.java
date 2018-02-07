package com.caci.exception;

/**
 * Classe Exception qui represente une ressource non trouvée
 * 
 * @author Slimane
 *
 */
public class ResourceNotFoundException extends RuntimeException {
	 
   
	private static final long serialVersionUID = -7225972345940221024L;
	private Long resourceId;
 
    public ResourceNotFoundException(Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
}