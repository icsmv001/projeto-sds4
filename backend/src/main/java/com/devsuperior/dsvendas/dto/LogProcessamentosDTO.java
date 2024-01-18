package com.devsuperior.dsvendas.dto;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LogProcessamentosDTO   {
	  private  Integer ID_SEQLOG;            
	  
	  @JsonFormat(pattern = "dd/MM/yyyy") // Especifica o formato da data
	  private  Date    DATA;                 
	  private  String  HORA;                 
	  private  String  STATUS;               
	  private  String  ID_ESTRUTURA;         
	  private  String  TIPO_CARGA;           
	  private  String  SIGLA;                
	  private  String  ID_CLIENTECORPORATIVO;
	  private  String  ID_CONTRATO;          
	  private  String  DESCRICAO;            
	  private  String  TIPOCARTEIRA;         
	  private  String  LOCAL_ARQUIVO;        
	  private  String  TOTALREGISTROS;       
	  private  String  REGCORRETOS;          
	  private  String  REGINCORRETOS;        
	  private  String  REGENVVENCIDO;        
	  private  String  PERCENTUAL_CORRETO;   
	  private  String  PERCENTUAL_INCORRETO; 
	  private  String  PERCENTUAL_VENCIDOS;
	  
 
	
	public Integer getID_SEQLOG() {
		return ID_SEQLOG;
	}
	public void setID_SEQLOG(Integer iD_SEQLOG) {
		ID_SEQLOG = iD_SEQLOG;
	}
	
	@JsonFormat(pattern = "dd/MM/yyyy") // Especifica o formato da data
	public Date getDATA() {
		return DATA;
	}
	public void setDATA(Date dATA) {
		DATA = dATA;
	}
	public String getHORA() {
		return HORA;
	}
	public void setHORA(String hORA) {
		HORA = hORA;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
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
	public String getID_CLIENTECORPORATIVO() {
		return ID_CLIENTECORPORATIVO;
	}
	public void setID_CLIENTECORPORATIVO(String iD_CLIENTECORPORATIVO) {
		ID_CLIENTECORPORATIVO = iD_CLIENTECORPORATIVO;
	}
	public String getID_CONTRATO() {
		return ID_CONTRATO;
	}
	public void setID_CONTRATO(String iD_CONTRATO) {
		ID_CONTRATO = iD_CONTRATO;
	}
	public String getDESCRICAO() {
		return DESCRICAO;
	}
	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}
	public String getTIPOCARTEIRA() {
		return TIPOCARTEIRA;
	}
	public void setTIPOCARTEIRA(String tIPOCARTEIRA) {
		TIPOCARTEIRA = tIPOCARTEIRA;
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
	
	

@JsonCreator
public LogProcessamentosDTO( @JsonProperty("ID_SEQLOG            ")  Integer   ID_SEQLOG                 ,
 @JsonProperty("DATA                 ")  Date      DATA                      ,
 @JsonProperty("HORA                 ")  String    HORA                      ,
 @JsonProperty("STATUS               ")  String    STATUS                    ,
 @JsonProperty("ID_ESTRUTURA         ")  String    ID_ESTRUTURA              ,
 @JsonProperty("TIPO_CARGA           ")  String    TIPO_CARGA                ,
 @JsonProperty("SIGLA                ")  String    SIGLA                     ,
 @JsonProperty("ID_CLIENTECORPORATIVO")  String    ID_CLIENTECORPORATIVO     ,
 @JsonProperty("ID_CONTRATO          ")  String    ID_CONTRATO               ,
 @JsonProperty("DESCRICAO            ")  String    DESCRICAO                 ,
 @JsonProperty("TIPOCARTEIRA         ")  String    TIPOCARTEIRA              ,
 @JsonProperty("LOCAL_ARQUIVO        ")  String    LOCAL_ARQUIVO             ,
 @JsonProperty("TOTALREGISTROS       ")  String    TOTALREGISTROS            ,
 @JsonProperty("REGCORRETOS          ")  String    REGCORRETOS               ,
 @JsonProperty("REGINCORRETOS        ")  String    REGINCORRETOS             ,
 @JsonProperty("REGENVVENCIDO        ")  String    REGENVVENCIDO             ,
 @JsonProperty("PERCENTUAL_CORRETO   ")  String    PERCENTUAL_CORRETO        ,
 @JsonProperty("PERCENTUAL_INCORRETO ")  String    PERCENTUAL_INCORRETO      ,
 @JsonProperty("PERCENTUAL_VENCIDOS  ")  String    PERCENTUAL_VENCIDOS       ) {
	        
		this.ID_SEQLOG = ID_SEQLOG;
		this.DATA = DATA;
		this.HORA = HORA;
		this.STATUS = STATUS;
		this.ID_ESTRUTURA = ID_ESTRUTURA;
		this.TIPO_CARGA = TIPO_CARGA;
		this.SIGLA = SIGLA;
		this.ID_CLIENTECORPORATIVO = ID_CLIENTECORPORATIVO;
		this.ID_CONTRATO = ID_CONTRATO;
		this.DESCRICAO = DESCRICAO;
		this.TIPOCARTEIRA = TIPOCARTEIRA;
		this.LOCAL_ARQUIVO = LOCAL_ARQUIVO;
		this.TOTALREGISTROS = TOTALREGISTROS;
		this.REGCORRETOS = REGCORRETOS;
		this.REGINCORRETOS = REGINCORRETOS;
		this.REGENVVENCIDO = REGENVVENCIDO;
		this.PERCENTUAL_CORRETO = PERCENTUAL_CORRETO;
		this.PERCENTUAL_INCORRETO = PERCENTUAL_INCORRETO;
		this.PERCENTUAL_VENCIDOS = PERCENTUAL_VENCIDOS;
	    }



//construtor vazio
public LogProcessamentosDTO(){
	
}


 
      
 





}
 





		 
	     
	 
