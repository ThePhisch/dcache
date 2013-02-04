// generated by GLUE/wsdl2java on Thu Jan 13 10:36:54 CST 2005
package diskCacheV111.srm;

import java.io.Serializable;

public class RequestFileStatus extends FileMetaData implements Serializable
  {
      private static final long serialVersionUID = 7757705606262452589L;
      public String state = RequestStatus.EMPTY;
  public int fileId;
  public String TURL = RequestStatus.EMPTY;
  public int estSecondsToStart;
  public String sourceFilename = RequestStatus.EMPTY;
  public String destFilename = RequestStatus.EMPTY;
  public int queueOrder;
  
  public RequestFileStatus() {
        super();
    }

     public RequestFileStatus(FileMetaData fmd) {
        super(fmd);
    }
     
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RequestFileStatus         SURL :").
        append(SURL).append('\n');
        sb.append("                     size :")
        .append(size).append('\n');
        sb.append("                     owner :")
        .append(owner).append('\n');
        sb.append("                     group :")
        .append(group).append('\n');
        sb.append("                     permMode :")
        .append(permMode).append('\n');
        sb.append("                     checksumType :")
        .append(checksumType).append('\n');
        sb.append("                     checksumValue :")
        .append(checksumValue).append('\n');
        sb.append("                     isPinned :")
        .append(isPinned).append('\n');
        sb.append("                     isPermanent :")
        .append(isPermanent).append('\n');
        sb.append("                     isCached :")
        .append(isCached).append('\n');
        sb.append("                     state :")
        .append(state).append('\n');
        sb.append("                     fileId :")
        .append(fileId).append('\n');
        sb.append("                     TURL :")
        .append(TURL).append('\n');
        sb.append("                     estSecondsToStart :")
        .append(estSecondsToStart).append('\n');
        sb.append("                     sourceFilename :")
        .append(sourceFilename).append('\n');
        sb.append("                     destFilename :")
        .append(destFilename).append('\n');
        sb.append("                     queueOrder :")
        .append(queueOrder).append('\n');
        return sb.toString();
    }
 
 }
