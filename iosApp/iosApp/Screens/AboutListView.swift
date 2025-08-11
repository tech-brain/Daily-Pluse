//
//  AboutListView.swift
//  iosApp
//
//  Created by Anil Kumar on 09/08/25.
//

import SwiftUI
import ComposeApp


struct AboutListView: View {
    private struct RowItem: Hashable {
        let title: String
        let subtitle: String
    }

    @State private var items: [RowItem] = []

    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
        .task {
            await loadPlatformInfoIfNeeded()
        }
        .onAppear {
            // If previews don't run .task reliably, ensure preview data appears
            if ProcessInfo.processInfo.environment["XCODE_RUNNING_FOR_PREVIEWS"] == "1" {
                items = [
                    .init(title: "Operating System", subtitle: "iOS 18.0 (Preview)"),
                    .init(title: "Device", subtitle: "iPhone 15 (Preview)"),
                    .init(title: "Density", subtitle: "@3")
                ]
            }
        }
    }

    /// Load KMM Platform info safely on the main thread (after view appears)
    private func loadPlatformInfoIfNeeded() async {
        // guard early if already loaded
        if !items.isEmpty { return }

        // Run on main thread because UI/state updates must be main
        await MainActor.run {
            do {
                // Wrap in a small do-catch if you expect throws (KMM typically doesn't throw to Swift)
            
                
                let p = Platform()
                p.logSystemInfo()

                let osName = p.osName ?? "Unknown"
                let osVersion = p.osVersion ?? ""
                let device = p.deviceModel ?? "Unknown"
                // density is int (not optional?) — coerce to string safely
                let densityString = String(describing: p.density)

                items = [
                    .init(title: "Operating System", subtitle: "\(osName) \(osVersion)"),
                    .init(title: "Device", subtitle: device),
                    .init(title: "Density", subtitle: "@\(densityString)")
                ]

            } catch {
                // Keep fallback safe UI if anything unexpected happens
                items = [
                    .init(title: "Operating System", subtitle: "Unknown"),
                    .init(title: "Device", subtitle: "Unknown"),
                    .init(title: "Density", subtitle: "N/A")
                ]
                print("Failed to load Platform info: \(error)")
            }
        }
    }
}

#Preview {
    AboutListView()
}
