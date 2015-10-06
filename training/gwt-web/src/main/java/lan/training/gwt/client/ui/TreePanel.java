package lan.training.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import lan.training.gwt.client.AuthorRemoteService;
import lan.training.gwt.client.AuthorRemoteServiceAsync;
import lan.training.gwt.client.BookRemoteService;
import lan.training.gwt.client.BookRemoteServiceAsync;
import lan.training.gwt.client.LanguageRemoteService;
import lan.training.gwt.client.LanguageRemoteServiceAsync;
import lan.training.gwt.client.PublisherRemoteService;
import lan.training.gwt.client.PublisherRemoteServiceAsync;
import lan.training.gwt.shared.dto.AuthorDto;
import lan.training.gwt.shared.dto.BookDto;
import lan.training.gwt.shared.dto.LanguageDto;
import lan.training.gwt.shared.dto.PublisherDto;

import java.util.List;

/**
 * Panel for Tree
 * @author nik-lazer  06.10.2015   11:54
 */
public class TreePanel extends SimplePanel {

	private final BookRemoteServiceAsync bookService = GWT.create(BookRemoteService.class);
	private final AuthorRemoteServiceAsync authorService = GWT.create(AuthorRemoteService.class);
	private final PublisherRemoteServiceAsync publisherService = GWT.create(PublisherRemoteService.class);
	private final LanguageRemoteServiceAsync languageService = GWT.create(LanguageRemoteService.class);

	private Label booksLabel;
	private Label authorsLabel;
	private Label publishersLabel;
	private Label languagesLabel;

	public TreePanel(final GridPanel gridPanel) {
		Tree staticTree = new Tree();
		booksLabel = new Label("Books");
		TreeItem booksItem = new TreeItem(booksLabel);
		booksLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				bookService.getList(new AsyncCallback<List<BookDto>>() {
					@Override
					public void onFailure(Throwable caught) {
						DialogBox dialogBox = new DialogBox();
						dialogBox.setTitle("Remote Procedure Call - Failure");
						dialogBox.setHTML(caught.getMessage());
						dialogBox.center();
					}

					@Override
					public void onSuccess(List<BookDto> result) {
						gridPanel.initBookTable(result);
					}
				});
			}
		});

		staticTree.addItem(booksItem);
		authorsLabel = new Label("Authors");
		authorsLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				authorService.getList(new AsyncCallback<List<AuthorDto>>() {
					@Override
					public void onFailure(Throwable caught) {
						DialogBox dialogBox = new DialogBox();
						dialogBox.setTitle("Remote Procedure Call - Failure");
						dialogBox.setHTML(caught.getMessage());
						dialogBox.center();
					}

					@Override
					public void onSuccess(List<AuthorDto> result) {
						gridPanel.initAuthorTable(result);
					}
				});
			}
		});

		staticTree.addItem(authorsLabel);
		publishersLabel = new Label("Publishers");
		publishersLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				publisherService.getList(new AsyncCallback<List<PublisherDto>>() {
					@Override
					public void onFailure(Throwable caught) {
						DialogBox dialogBox = new DialogBox();
						dialogBox.setTitle("Remote Procedure Call - Failure");
						dialogBox.setHTML(caught.getMessage());
						dialogBox.center();
					}

					@Override
					public void onSuccess(List<PublisherDto> result) {
						gridPanel.initPublisherTable(result);
					}
				});
			}
		});

		staticTree.addItem(publishersLabel);
		languagesLabel = new Label("Languages");
		staticTree.addItem(languagesLabel);
		languagesLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				languageService.getList(new AsyncCallback<List<LanguageDto>>() {
					@Override
					public void onFailure(Throwable caught) {
						DialogBox dialogBox = new DialogBox();
						dialogBox.setTitle("Remote Procedure Call - Failure");
						dialogBox.setHTML(caught.getMessage());
						dialogBox.center();
					}

					@Override
					public void onSuccess(List<LanguageDto> result) {
						gridPanel.initLanguageTable(result);
					}
				});
			}
		});

		add(staticTree);
	}
}
