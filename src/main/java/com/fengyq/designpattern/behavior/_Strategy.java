package com.fengyq.designpattern.behavior;

import java.util.HashMap;

public class _Strategy {
	static abstract class IStrategy {
		public abstract void execute(Object arg);
	}
	static class StrategyA extends IStrategy {
        @Override
        public void execute(Object arg) {
            System.out.println("执行策略A："+arg);
        }
    }
    static class StrategyB extends IStrategy {
        @Override
        public void execute(Object arg) {
            System.out.println("执行策略B："+arg);
        }
    }
	static class Context {
		IStrategy IStrategy;
		public Context(IStrategy IStrategy) {
			this.IStrategy = IStrategy;
		}
		public void execute(Object arg) {
			IStrategy.execute(arg);
		}
	}

	//以下是通过工厂的方式，map就相当于工厂，里面装满了策略，context中组合map而不是Strategy了---------------------- begin
	static class StrategyFactory {
	    /*map就相当于工厂*/
        static private HashMap<Integer, IStrategy> strategyFactory;
		static {
            strategyFactory =new HashMap<>();
            strategyFactory.put(1, new StrategyA());
            strategyFactory.put(2, new StrategyB());
            /*也可以通过spring的方式注入初始化好的map
            @Resource
            static private HashMap<Integer, IStrategy> strategyFactory;

            <bean id="strategyFactory" class="java.util.HashMap">
                <constructor-arg>
                    <map key-type="java.lang.Integer">
                        <entry key="1" value-ref="StrategyA"/>
                        <entry key="2" value-ref="StrategyB"/>
                    </map>
                </constructor-arg>
		    </bean>
		   */
        }

		public static void execute(Integer type) {
			IStrategy IStrategy = strategyFactory.get(type);
			IStrategy.execute("StrategyFactory");
            /**用map可以消除if else
             * if(type==1) {
                  IStrategy=new StrategyA();
               }else if(type==2) {
               IStrategy=new StrategyB();
             }
             */
		}
	}
	//以下是通过工厂的方式，map就相当于工厂，里面装满了策略，context中组合map而不是Strategy了---------------------- end

	public static void main(String[] args) {
		IStrategy IStrategy =new StrategyA();
		Context context=new Context(IStrategy);
		context.execute("策略参数");

		//策略+工厂
        StrategyFactory.execute(1);
	}
}
