package util;

/**
 * һ�����ڴ�������Ϣ��json���Ͷ���
 * @author zhang jin sheng
 *
 */
public class LayuiEdiePicData {

	public static final int FLAG_SUCC = 0;  //����ɹ�
    public static final int FLAG_FAIL = 1;  //����ʧ��

    public int code; //������״̬��
    public String msg;  //������������Ϣ
    //�����ؽ����������һ����ת��Ϊjson��ʽ���ַ�
    public Object data;
    
    public LayuiEdiePicData(){
    	this.code = FLAG_FAIL;
    	this.msg = null;
    	this.data = null;
    }
}
