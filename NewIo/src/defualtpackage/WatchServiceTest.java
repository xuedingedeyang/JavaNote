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
		//获取文件系统的WatchService对象
		WatchService watchService = FileSystems.getDefault().newWatchService();
		
		Paths.get("E:").register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		while(true){
			//获取下一个文件变化事件
			WatchKey key = watchService.take();
			for(WatchEvent<?> event :key.pollEvents()){
				System.out.println(event.context() + "发生了" + event.kind() + "事件");
			}
			//重设watchKey
			boolean valid = key.reset();
			if(!valid){
				//如果重设失败，退出监听
				break;
			}
		}
	}

}
