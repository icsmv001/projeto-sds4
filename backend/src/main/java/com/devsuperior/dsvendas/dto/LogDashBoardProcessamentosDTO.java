package com.devsuperior.dsvendas.dto;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LogDashBoardProcessamentosDTO   {
	 
	  private  Integer ID_SEQLOG; 
	  private  String  MONITORACAO;
	  private  String  ID_ESTRUTURA; 
	  private  String  SIGLA;                
	  private  String  TIPO_CARGA;           
	  @JsonFormat(pattern = "dd/MM/yyyy") // Especifica o formato da data
	  private  Date    DATA_CALENDARIO; 
	  private  String  HORA;  
	  private  String  STATUS_LOG;               
	  private  String  TOTALREGISTROS;       
	  private  String  REGCORRETOS;          
	  private  String  REGINCORRETOS;        
	  private  String  REGENVVENCIDO;        
	  private  String  PERCENTUAL_CORRETO;   
	  private  String  PERCENTUAL_INCORRETO; 
	  private  String  PERCENTUAL_VENCIDOS;
	  private  String  REGENVINCLUSAO;        
	  private  String  REGENVALTERACAO;       
	  private  String  REGENVCANCELAMENTO;  
	  private  String  NM_ESTRUTURA; 
	  private  String  ID_CLIENTE;
	  private  String  NM_CLIENTE; 
	  private  String  ID_CONTRATO;          
	  private  String  NM_CONTRATO;            
	  private  String  SEGMENTO;         
	  private  String  LOCAL_ARQUIVO; 
	  private  String  ANO_MES;
	  private  Integer  TRATADO_SN;
	  
	  
		 
		  
 
	  /**
	   * @return the mONITORACAO
	   */
	  public String getMONITORACAO() {
	  	return MONITORACAO;
	  }
	  /**
	   * @param mONITORACAO the mONITORACAO to set
	   */
	  public void setMONITORACAO(String mONITORACAO) {
	  	MONITORACAO = mONITORACAO;
	  }

	 
	  public Integer getID_SEQLOG() {
			return ID_SEQLOG;
		}
		public void setID_SEQLOG(Integer iD_SEQLOG) {
			ID_SEQLOG = iD_SEQLOG;
		}
	  
	public Integer getINDECE() {
		return ID_SEQLOG;
	}
	public void setINDECE(Integer iNDECE) {
		ID_SEQLOG = iNDECE;
	}
	
	@JsonFormat(pattern = "dd/MM/yyyy") // Especifica o formato da data
	public Date getDATA_CALENDARIO() {
		return DATA_CALENDARIO;
	}
	public void setDATA_CALENDARIO(Date dATA_CALENDARIO) {
		DATA_CALENDARIO = dATA_CALENDARIO;
	}
	public String getHORA() {
		return HORA;
	}
	public void setHORA(String hORA) {
		HORA = hORA;
	}
	public String getSTATUS_LOG() {
		return STATUS_LOG;
	}
	public void setSTATUS_LOG(String sTATUS_LOG) {
		STATUS_LOG = sTATUS_LOG;
	}
	
	
	public String getID_ESTRUTURA() {
		return ID_ESTRUTURA;
	}
	public void setID_ESTRUTURA(String iD_ESTRUTURA) {
		ID_ESTRUTURA = iD_ESTRUTURA;
	}
	
		
	public String getTIPO_CARGA() {
		return TIPO_CARGA;
	}
	public void setTIPO_CARGA(String tIPO_CARGA) {
		TIPO_CARGA = tIPO_CARGA;
	}
	public String getSIGLA() {
		return SIGLA;
	}
	public void setSIGLA(String sIGLA) {
		SIGLA = sIGLA;
	}
	public String getID_CLIENTE() {
		return ID_CLIENTE;
	}
	public void setID_CLIENTE(String iD_CLIENTE) {
		ID_CLIENTE = iD_CLIENTE;
	}
	public String getID_CONTRATO() {
		return ID_CONTRATO;
	}
	public void setID_CONTRATO(String iD_CONTRATO) {
		ID_CONTRATO = iD_CONTRATO;
	}
	public String getNM_CONTRATO() {
		return NM_CONTRATO;
	}
	public void setNM_CONTRATO(String nM_CONTRATO) {
		NM_CONTRATO = nM_CONTRATO;
	}
	public String getSEGMENTO() {
		return SEGMENTO;
	}
	public void setSEGMENTO(String sEGMENTO) {
		SEGMENTO = sEGMENTO;
	}
	public String getLOCAL_ARQUIVO() {
		return LOCAL_ARQUIVO;
	}
	public void setLOCAL_ARQUIVO(String lOCAL_ARQUIVO) {
		LOCAL_ARQUIVO = lOCAL_ARQUIVO;
	}
	public String getTOTALREGISTROS() {
		return TOTALREGISTROS;
	}
	public void setTOTALREGISTROS(String tOTALREGISTROS) {
		TOTALREGISTROS = tOTALREGISTROS;
	}
	public String getREGCORRETOS() {
		return REGCORRETOS;
	}
	public void setREGCORRETOS(String rEGCORRETOS) {
		REGCORRETOS = rEGCORRETOS;
	}
	public String getREGINCORRETOS() {
		return REGINCORRETOS;
	}
	public void setREGINCORRETOS(String rEGINCORRETOS) {
		REGINCORRETOS = rEGINCORRETOS;
	}
	public String getREGENVVENCIDO() {
		return REGENVVENCIDO;
	}
	public void setREGENVVENCIDO(String rEGENVVENCIDO) {
		REGENVVENCIDO = rEGENVVENCIDO;
	}
	public String getPERCENTUAL_CORRETO() {
		return PERCENTUAL_CORRETO;
	}
	public void setPERCENTUAL_CORRETO(String pERCENTUAL_CORRETO) {
		PERCENTUAL_CORRETO = pERCENTUAL_CORRETO;
	}
	public String getPERCENTUAL_INCORRETO() {
		return PERCENTUAL_INCORRETO;
	}
	public void setPERCENTUAL_INCORRETO(String pERCENTUAL_INCORRETO) {
		PERCENTUAL_INCORRETO = pERCENTUAL_INCORRETO;
	}
	public String getPERCENTUAL_VENCIDOS() {
		return PERCENTUAL_VENCIDOS;
	}
	public void setPERCENTUAL_VENCIDOS(String pERCENTUAL_VENCIDOS) {
		PERCENTUAL_VENCIDOS = pERCENTUAL_VENCIDOS;
	}
	
	public Integer getTRATADO_SN() {
		return TRATADO_SN;
	}
	public void setTRATADO_SN(Integer tRATADO_SN) {
		TRATADO_SN = tRATADO_SN;
	}


@JsonCreator
public LogDashBoardProcessamentosDTO( 
		
		 @JsonProperty ("MONITORACAO         ")   String   MONITORACAO         ,  
		 @JsonProperty ("ID_ESTRUTURA        ")   String  ID_ESTRUTURA        ,     
		 @JsonProperty ("SIGLA               ")   String   SIGLA               ,
		 @JsonProperty ("TIPO_CARGA          ")   String   TIPO_CARGA          ,
		 @JsonProperty ("DATA_CALENDARIO     ")   Date     DATA_CALENDARIO     ,     
		 @JsonProperty ("HORA                ")   String   HORA                ,
		 @JsonProperty ("ID_SEQLOG           ")   Integer  ID_SEQLOG          ,
		 @JsonProperty ("STATUS_LOG          ")   String   STATUS_LOG          ,   
		 @JsonProperty ("TOTALREGISTROS      ")   String   TOTALREGISTROS      ,
		 @JsonProperty ("REGCORRETOS         ")   String   REGCORRETOS         ,
		 @JsonProperty ("REGINCORRETOS       ")   String   REGINCORRETOS       ,
		 @JsonProperty ("REGENVVENCIDO       ")   String   REGENVVENCIDO       ,
		 @JsonProperty ("PERCENTUAL_CORRETO  ")   String   PERCENTUAL_CORRETO  ,
		 @JsonProperty ("PERCENTUAL_INCORRETO")   String   PERCENTUAL_INCORRETO,
		 @JsonProperty ("PERCENTUAL_VENCIDOS ")   String   PERCENTUAL_VENCIDOS ,
		 @JsonProperty ("REGENVINCLUSAO      ")   String   REGENVINCLUSAO      ,
		 @JsonProperty ("REGENVALTERACAO     ")   String   REGENVALTERACAO     ,
		 @JsonProperty ("REGENVCANCELAMENTO  ")   String   REGENVCANCELAMENTO  ,
		 @JsonProperty ("NM_ESTRUTURA        ")   String   NM_ESTRUTURA        ,
		 @JsonProperty ("ID_CLIENTE          ")   String   ID_CLIENTE          ,
		 @JsonProperty ("NM_CLIENTE          ")   String   NM_CLIENTE          ,
		 @JsonProperty ("ID_CONTRATO         ")   String   ID_CONTRATO         ,
		 @JsonProperty ("NM_CONTRATO         ")   String   NM_CONTRATO         ,
		 @JsonProperty ("SEGMENTO            ")   String   SEGMENTO            ,
		 @JsonProperty ("LOCAL_ARQUIVO       ")   String   LOCAL_ARQUIVO       ,
		 @JsonProperty ("ANO_MES             ")   String   ANO_MES             ,
		 @JsonProperty ("TRATADO_SN          ")   Integer   TRATADO_SN 	       ,	   
		 @JsonProperty ("INDECE              ")   Integer  INDECE 			   ) {
			        
	this.MONITORACAO          = MONITORACAO         ;
	this.ID_ESTRUTURA         = ID_ESTRUTURA        ;
	this.SIGLA                = SIGLA               ;
	this.TIPO_CARGA           = TIPO_CARGA          ;
	this.DATA_CALENDARIO      = DATA_CALENDARIO     ;
	this.HORA                 = HORA                ;
	this. ID_SEQLOG           = ID_SEQLOG           ;
	this.STATUS_LOG           = STATUS_LOG          ;
	this.TOTALREGISTROS       = TOTALREGISTROS      ;
	this.REGCORRETOS          = REGCORRETOS         ;
	this.REGINCORRETOS        = REGINCORRETOS       ;
	this.REGENVVENCIDO        = REGENVVENCIDO       ;
	this.PERCENTUAL_CORRETO   = PERCENTUAL_CORRETO  ;
	this.PERCENTUAL_INCORRETO = PERCENTUAL_INCORRETO;
	this.PERCENTUAL_VENCIDOS  = PERCENTUAL_VENCIDOS ;
	this.REGENVINCLUSAO       = REGENVINCLUSAO      ;
	this.REGENVALTERACAO      = REGENVALTERACAO     ;
	this.REGENVCANCELAMENTO   = REGENVCANCELAMENTO  ;
	this.NM_ESTRUTURA         = NM_ESTRUTURA        ;
	this.ID_CLIENTE           = ID_CLIENTE          ;
	this.NM_CLIENTE           = NM_CLIENTE          ;
	this.ID_CONTRATO          = ID_CONTRATO         ;
	this.NM_CONTRATO          = NM_CONTRATO         ;
	this.SEGMENTO             = SEGMENTO            ;
	this.LOCAL_ARQUIVO        = LOCAL_ARQUIVO       ;
	this.ANO_MES              = ANO_MES             ;
	this.TRATADO_SN           = TRATADO_SN          ;
	
	    }



//construtor vazio
public LogDashBoardProcessamentosDTO(){
	
}
/**
 * @return the rEGENVINCLUSAO
 */
public String getREGENVINCLUSAO() {
	return REGENVINCLUSAO;
}
/**
 * @param rEGENVINCLUSAO the rEGENVINCLUSAO to set
 */
public void setREGENVINCLUSAO(String rEGENVINCLUSAO) {
	REGENVINCLUSAO = rEGENVINCLUSAO;
}
/**
 * @return the rEGENVALTERACAO
 */
public String getREGENVALTERACAO() {
	return REGENVALTERACAO;
}
/**
 * @param rEGENVALTERACAO the rEGENVALTERACAO to set
 */
public void setREGENVALTERACAO(String rEGENVALTERACAO) {
	REGENVALTERACAO = rEGENVALTERACAO;
}
/**
 * @return the rEGENVCANCELAMENTO
 */
public String getREGENVCANCELAMENTO() {
	return REGENVCANCELAMENTO;
}
/**
 * @param rEGENVCANCELAMENTO the rEGENVCANCELAMENTO to set
 */
public void setREGENVCANCELAMENTO(String rEGENVCANCELAMENTO) {
	REGENVCANCELAMENTO = rEGENVCANCELAMENTO;
}
/**
 * @return the nM_ESTRUTURA
 */
public String getNM_ESTRUTURA() {
	return NM_ESTRUTURA;
}
/**
 * @param nM_ESTRUTURA the nM_ESTRUTURA to set
 */
public void setNM_ESTRUTURA(String nM_ESTRUTURA) {
	NM_ESTRUTURA = nM_ESTRUTURA;
}
/**
 * @return the nM_CLIENTE
 */
public String getNM_CLIENTE() {
	return NM_CLIENTE;
}
/**
 * @param nM_CLIENTE the nM_CLIENTE to set
 */
public void setNM_CLIENTE(String nM_CLIENTE) {
	NM_CLIENTE = nM_CLIENTE;
}
/**
 * @return the aNO_MES
 */
public String getANO_MES() {
	return ANO_MES;
}
/**
 * @param aNO_MES the aNO_MES to set
 */
public void setANO_MES(String aNO_MES) {
	ANO_MES = aNO_MES;
}






 
      
 





}
 





		 
	     
	 
