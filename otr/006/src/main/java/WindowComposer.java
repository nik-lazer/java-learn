import model.Group;
import model.ModelHelper;
import tree.MainTreeNode;
import tree.RootTreeNode;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tree;

import java.util.List;

import static org.fluentjava.FluentUtils.list;

/**
 * @author Alexey Pobedyonny 25.02.2014
 */
public class WindowComposer extends GenericForwardComposer {
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		final Label l = new Label("Welcome");
		comp.appendChild(l);

		final Tree tree = new Tree();
		final List<Group> pojoModel = ModelHelper.createModel();
		MainTreeNode mainTreeNode = new MainTreeNode(pojoModel);
		DefaultTreeModel treeModel = new DefaultTreeModel(mainTreeNode);
		mainTreeNode.setModel(treeModel);
		tree.setModel(treeModel);
		//tree.setModel(new DefaultTreeModel(new RootTreeNode(pojoModel)));
//		tree.setItemRenderer(new TreeitemRenderer<Object>() {
//			public void render(Treeitem item, Object data, int index) throws Exception {
//				Treerow row = new Treerow();
//				final Treecell1 cell = new Treecell1();
//				row.appendChild(cell);
//				if(data instanceof DefaultTreeNode) {
//					final Label child = new Label(data.toString());
//					cell.appendChild(child);
//					final Button child1 = new Button("Click me");
//					child1.setId("asd");
//					child1.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
//						public void onEvent(Event event) throws Exception {
//							cell.setStyle("background-color: black;");
//						}
//					});
//					cell.appendChild(child1);
//				} else if(data instanceof Student) {
//					cell.appendChild(new Label(((Student) data).getName()));
//				}
//				item.appendChild(row);
//			}
//		});
		comp.appendChild(tree);

		final Button button = new Button("Add student");
		comp.appendChild(button);
		button.addEventListener(Events.ON_CLICK, new SerializableEventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				//final Group newGroup = new Group("Математика", list("Иванов", "Петров"), String.format("Предмет %d", ++grpCounter), new String("Студент " + ++studentCounter));
				//RootTreeNode root = (RootTreeNode) tree.getModel().getRoot();

				//root.add(new DefaultTreeNode(newGroup));
			}
		});
		comp.addForward(Events.ON_OK, button, Events.ON_CLICK);
		final Button printButton = new Button("Print students");
		comp.appendChild(printButton);
		printButton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				System.out.println(pojoModel);
			}
		});
	}

	public static int grpCounter = 0;
	public static int studentCounter = 0;

}
