package com.ceiba.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZuulProxyServerApplication.class)
public class ZuulProxyServerApplicationTests {

	@Test
    public void main() {
		ZuulProxyServerApplication.main(new String[] {});
   }

}
