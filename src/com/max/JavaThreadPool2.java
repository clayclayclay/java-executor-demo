
package com.max;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.max.task.SimpleCallableTask;

public class JavaThreadPool2
{

	public static void main(String[] args)
	{
		/*
		 * Create a fixed thread pool by Class `Executors`, method `newFixedThreadPool` ����һ�������ù̶��߳������̳߳�
		 */
		ExecutorService pool = Executors.newFixedThreadPool(2);

		/*
		 * create a Future list to trace thread's state. ����һ��FutureList,����׷���߳�״̬
		 */
		List<Future<String>> resultList = new ArrayList<Future<String>>();

		for (int i = 0; i < 10; i++)
		{

			/*
			 * submit Callable task by ExecutorService, and return Future.
			 * ʹ��ExecutorServiceִ��Callable���͵����񣬲������������future������
			 */
			Future<String> future = pool.submit(new SimpleCallableTask(i));
			resultList.add(future);
		}

		for (Future<String> fs : resultList)
		{
			try
			{
				/*
				 * loop check is the thread is done by method 'isDone()', Future�������û����ɣ���һֱѭ���ȴ���ֱ��Future�������
				 */
				while (!fs.isDone())
				{
				}

				/*
				 * print thread's result. ��ӡ�����̣߳�����ִ�еĽ��
				 */
				System.out.println(fs.get());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			catch (ExecutionException e)
			{
				e.printStackTrace();
			}
			finally
			{
				/*
				 * execute submited task before from task Queue, but doesn't accept new task. ����һ��˳��رգ�ִ����ǰ�ύ�����񣬵�������������
				 */
				pool.shutdown();
			}
		}

		while (!(pool.isTerminated()))
		{
		}

		System.out.println("finished all threads, and the thread pool has been terminated");

	}
}
