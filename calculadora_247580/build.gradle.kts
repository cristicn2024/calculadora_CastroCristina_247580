import org.jetbrains.kotlin.fir.references.builder.buildFromMissingDependenciesNamedReference
import org.jetbrains.kotlin.ir.backend.js.lower.collectNativeImplementations
import org.jetbrains.kotlin.util.findImplementationFromInterface
import org.jetbrains.kotlin.util.findInterfaceImplementation

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

}