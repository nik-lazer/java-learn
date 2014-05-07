import org.jetbrains.annotations.Nullable;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;

/**
 * @author Alexey Pobedyonny 07.05.2014
 */
public class Service {
	protected PropertyService propertyService;
	private int counter = 0;

	public Object eval(Object param, String eval) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(eval);
		return exp.getValue(param);
	}

	public int eval(String eval) {
		incCounter();
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(eval);
		if(!Number.class.isAssignableFrom(exp.getValueType())) {
			throw new IllegalArgumentException("Результат выражения должен быть числом");
		}
		return ((Number) exp.getValue()).intValue();
	}

	private void incCounter() {
		counter++;
	}

	public @Nullable String getProperty(String key) {
		incCounter();
		if(propertyService.hasProperty(key)) {
			return propertyService.getProperty(key);
		}
		return System.getProperty(key, null);
	}

	public void setPropertyService(PropertyService propertyService) {
		this.propertyService = propertyService;
	}

	@Override
	public String toString() {
		return "Service invocations " + counter;
	}
}
