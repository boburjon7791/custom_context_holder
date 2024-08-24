package com.example.custom_context_holder;

import com.example.custom_context_holder.sub.model.dto.PaymentDto;
import com.example.custom_context_holder.sub.model.dto.ReportDto;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@EnableJpaAuditing
@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class CustomContextHolderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomContextHolderApplication.class, args);
	}

	@PostConstruct
	public void init(){
		Runnable runnable=() -> {
            try {
                TimeUnit.SECONDS.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            RestClient restClient= RestClient.builder().build();
			ZoneId.getAvailableZoneIds().forEach(System.out::println);

			/*LinkedHashMap body = restClient.get()
					.uri("http://localhost:8081/api/reports",uriBuilder -> uriBuilder.queryParam("time-zone","Europe/Moscow" ).build())
					.retrieve()
					.body(LinkedHashMap.class);
			List<Object> object = (ArrayList<Object>) body.get("content");
			object.forEach(System.out::println);*/

			/*PaymentDto paymentDto = PaymentDto.builder()
					.payment(BigDecimal.valueOf(125))
					.cashierName("John")
					.build();

			PaymentDto response = restClient.post()
					.uri("http://localhost:8081/api/payment")
					.contentType(MediaType.APPLICATION_JSON)
					.body(paymentDto)
					.retrieve()
					.body(PaymentDto.class);


			System.out.println("response = " + response);*/

			/*Map<String, String> objectObjectMap = Map.of(
					"time-zone","America/Toronto",
//					"fromPayment","120",
					"fromDate","2024-08-23T15:15:48.616522-04:00",
					"toDate","2024-08-23T15:15:53.616522-04:00"//,
//					"page","1",
//					"size","1"
			);
			MultiValueMap<String, String> multiValueMap=new LinkedMultiValueMap<>();
			objectObjectMap.forEach(multiValueMap::add);
			LinkedHashMap<String, Object> list = restClient.get()
					.uri("http://localhost:8081/api/payment"*//*, uriBuilder -> uriBuilder.replaceQueryParams(multiValueMap).build()*//*)
					.retrieve()
					.body(LinkedHashMap.class);

			List<LinkedHashMap<String, Object>> object = (List<LinkedHashMap<String, Object>>) list.get("content");
			object.forEach(System.out::println);*/

			/*String id="84d075d8-f114-43da-a0e2-18f6d488adc8";
			restClient.delete()
					.uri("http://localhost:8081/api/reports/"+id)
					.retrieve()
					.toBodilessEntity();
			System.out.println("id removed = " + id);*/

			/*LinkedHashMap<String, Object> body1 = restClient.get()
					.uri("http://localhost:8081/api/reports")
					.retrieve()
					.body(LinkedHashMap.class);
			List<LinkedHashMap<String, Object>> object1 = (List<LinkedHashMap<String, Object>>) body1.get("content");
			object1.forEach(System.out::println);*/
		};
		new Thread(runnable).start();
	}
}
