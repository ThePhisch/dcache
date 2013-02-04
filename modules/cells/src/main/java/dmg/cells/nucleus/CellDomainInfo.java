package dmg.cells.nucleus ;

import java.io.Serializable;

/**
  *  
  *
  * @author Patrick Fuhrmann
  * @version 0.1, 15 Feb 1998
  */
public class CellDomainInfo implements Serializable {

  private static final long serialVersionUID = 486982068268709272L;
  private String _domainName = "Unknown" ;
  
  public CellDomainInfo( String name ){ _domainName = name ; }
  void setCellDomainName( String name ){ _domainName = name ; }
  public String getCellDomainName(){ return _domainName ; }
  public String toString(){ return _domainName ; }

}
