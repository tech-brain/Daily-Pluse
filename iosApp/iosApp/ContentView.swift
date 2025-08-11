import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    
    @State private var shouldOpenAbout = false
    
    var body: some View {
        let articlesScreen =  ArticlesScreen(viewModel: .init())
        NavigationStack{
            articlesScreen
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenAbout){
                            AboutScreen()
                        }
                    }
                }
        }.refreshable {
            articlesScreen.viewModel.articlesViewModel.getArticles(forceFetch: true)
        }
        
    }
}



