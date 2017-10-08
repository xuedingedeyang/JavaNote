package defualtpackage;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//��ȡ�ļ�ϵͳ��WatchService����
		WatchService watchService = FileSystems.getDefault().newWatchService();
		
		Paths.get("E:").register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		while(true){
			//��ȡ��һ���ļ��仯�¼�
			WatchKey key = watchService.take();
			for(WatchEvent<?> event :key.pollEvents()){
				System.out.println(event.context() + "������" + event.kind() + "�¼�");
			}
			//����watchKey
			boolean valid = key.reset();
			if(!valid){
				//�������ʧ�ܣ��˳�����
				break;
			}
		}
	}

}
