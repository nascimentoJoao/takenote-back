package com.itacademy.takenote;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itacademy.takenote.controller.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TakenoteApplicationTests {
	
	@Autowired
	NoteController noteController;
	
	@Autowired
	GroupController groupController;

	@Test
	public void contextLoads() throws Exception{
		assertThat(noteController).isNotNull();
		assertThat(groupController).isNotNull();
	}

}
