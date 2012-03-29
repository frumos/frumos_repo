package dima.com.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRabbit {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("aopConfig.xml");
		
		RabbitTemplate template = (RabbitTemplate) context.getBean(AmqpTemplate.class);
			
		template.send("sync.topic", "operator.222", new Message("hello".getBytes(),new MessageProperties()));
	
		System.out.println(new String(template.receive("dima").getBody()));
		
		
	}
	

}
