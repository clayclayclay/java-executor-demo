
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
		 * Create a fixed thread pool by Class `Executors`, method `newFixedThreadPool` 创建一个可重用固定线程数的线程池
		 */
		ExecutorService pool = Executors.newFixedThreadPool(2);

		/*
		 * create a Future list to trace thread's state. 创建一个FutureList,用来追踪线程状态
		 */
		List<Future<String>> resultList = new ArrayList<Future<String>>();

		for (int i = 0; i < 10; i++)
		{

			/*
			 * submit Callable task by ExecutorService, and return Future.
			 * 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
			 */
			Future<String> future = pool.submit(new SimpleCallableTask(i));
			resultList.add(future);
		}

		for (Future<String> fs : resultList)
		{
			try
			{
				/*
				 * loop check is the thread is done by method 'isDone()', Future返回如果没有完成，则一直循环等待，直到Future返回完成
				 */
				while (!fs.isDone())
				{
				}

				/*
				 * print thread's result. 打印各个线程（任务）执行的结果
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
				 * execute submited task before from task Queue, but doesn't accept new task. 启动一次顺序关闭，执行以前提交的任务，但不接受新任务
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
