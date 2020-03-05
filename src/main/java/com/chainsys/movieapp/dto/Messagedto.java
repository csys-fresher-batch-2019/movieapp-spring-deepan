package com.chainsys.movieapp.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
@Data
@JsonInclude(Include.NON_NULL)
public class Messagedto {
		private String infoMessage;
		private String errorMessage;
		/**
		 * @return the infoMessage
		 */
		public String getInfoMessage() {
			return infoMessage;
		}
		/**
		 * @param infoMessage the infoMessage to set
		 */
		public void setInfoMessage(String infoMessage) {
			this.infoMessage = infoMessage;
		}
		/**
		 * @return the errorMessage
		 */
		public String getErrorMessage() {
			return errorMessage;
		}
		/**
		 * @param errorMessage the errorMessage to set
		 */
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
	}