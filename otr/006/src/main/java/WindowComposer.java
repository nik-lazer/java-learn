import model.Group;
import model.ModelHelper;
import model.Student;
import org.zkoss.zul.TreeNode;
import tree.CustomTreeRenderer;
import tree.GroupTreeNode;
import tree.MainTreeNode;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tree;
import tree.StudentTreeNode;

import java.util.List;
import java.util.Set;

import static org.fluentjava.FluentUtils.list;

/**
 * @author Alexey Pobedyonny 25.02.2014
 */
public class WindowComposer extends GenericForwardComposer {
	private Button addButton;
	private Button removeButton;
	private Button addToCouncil;
	private Button removeFromCouncil;

	@Override
	public void doAfterCompose(final Component comp) throws Exception {
		super.doAfterCompose(comp);

		final Label l = new Label("Welcome");
		comp.appendChild(l);

		final Tree tree = new Tree();
		final List<Group> pojoModel = ModelHelper.createModel();
		MainTreeNode mainTreeNode = new MainTreeNode();
		DefaultTreeModel treeModel = new DefaultTreeModel(mainTreeNode);
		mainTreeNode.setModel(treeModel);
		mainTreeNode.setGroups(pojoModel);
		tree.setModel(treeModel);
		tree.setItemRenderer(new CustomTreeRenderer());
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

		addButton = new Button("Add student");
		comp.appendChild(addButton);
		addButton.addEventListener(Events.ON_CLICK, new SerializableEventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				Set<TreeNode> selectedSet = ((DefaultTreeModel) tree.getModel()).getSelection();
				for (TreeNode treeNode : selectedSet) {
					if (treeNode instanceof GroupTreeNode) {
						GroupTreeNode groupTreeNode = (GroupTreeNode) treeNode;
						Student student = new Student("qwertyu");
						StudentTreeNode studentTreeNode = new StudentTreeNode(groupTreeNode, student);
						studentTreeNode.setGroupTreeNode(groupTreeNode);
						treeNode.add(studentTreeNode);
					}

				}
			}
		});
		comp.addForward(Events.ON_OK, addButton, Events.ON_CLICK);

		removeButton = new Button("Remove student");
		comp.appendChild(removeButton);
		removeButton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				Set<TreeNode> selectedSet = ((DefaultTreeModel) tree.getModel()).getSelection();
				for (TreeNode treeNode : selectedSet) {
					if (treeNode instanceof StudentTreeNode) {
						((StudentTreeNode) treeNode).getGroupTreeNode().remove(treeNode);
					}
				}
			}
		});

		addToCouncil = new Button("Add to council");
		comp.appendChild(addToCouncil);
		addToCouncil.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				Set<TreeNode> selectedSet = ((DefaultTreeModel) tree.getModel()).getSelection();
				for (TreeNode treeNode : selectedSet) {
					if (treeNode instanceof StudentTreeNode) {
						StudentTreeNode studentTreeNode = (StudentTreeNode) treeNode;
						GroupTreeNode groupTreeNode = studentTreeNode.getGroupTreeNode();
						Group group = groupTreeNode.getGroup();
						if (group.getCouncil().addToCouncil(studentTreeNode.getData())) {
							studentTreeNode.setInCouncil(true);
						}
					}
				}
			}
		});

		removeFromCouncil = new Button("Remove from council");
		comp.appendChild(removeFromCouncil);
		removeFromCouncil.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				Set<TreeNode> selectedSet = ((DefaultTreeModel) tree.getModel()).getSelection();
				for (TreeNode treeNode : selectedSet) {
					if (treeNode instanceof StudentTreeNode) {
						StudentTreeNode studentTreeNode = ((StudentTreeNode) treeNode);
						GroupTreeNode groupTreeNode = studentTreeNode.getGroupTreeNode();
						Group group = groupTreeNode.getGroup();
						group.getCouncil().removeFromCouncil(studentTreeNode.getData());
						studentTreeNode.setInCouncil(false);
					}
				}
			}
		});

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
