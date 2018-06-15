package com.sydney.sample.feature.kyro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.sydney.sample.feature.kryo.entity.Student;

public class KyroTest {

	@Test
	public void testSerialize(){
		try {
			Kryo kryo = new Kryo();
			Output output = new Output(new FileOutputStream("target/student.bin"));
			Student student = new Student();
			student.setName("name_1");
			kryo.writeObject(output,student);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KryoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeserialize(){
		try {
			Kryo kryo = new Kryo();
			Input input = new Input(new FileInputStream("target/student.bin"));
			Student student = kryo.readObject(input,Student.class);
			input.close();
			
			System.out.println(student.getName());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KryoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
